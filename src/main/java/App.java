import com.google.gson.Gson;
import dao.Sql2oEmployeeDao;
import dao.Sql2oDepartmentDao;
import dao.Sql2oNewsDao;
import exceptions.ApiException;
import models.Department;
import models.Employee;
import models.News;
import org.sql2o.*;
import static  spark.Spark.*;

public class App {

    public static void main(String[] args) {
        staticFileLocation("/public");

        ProcessBuilder process = new ProcessBuilder();
        Integer port;


        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 5432;
        }

        port(port);

        Sql2oNewsDao newsDao;
        Sql2oDepartmentDao departmentDao;
        Sql2oEmployeeDao employeeDao;
        Connection conn;
        Gson gson= new Gson();


        departmentDao = new Sql2oDepartmentDao(DB.sql2o);
        employeeDao = new Sql2oEmployeeDao(DB.sql2o);
        newsDao = new Sql2oNewsDao(DB.sql2o);
        final String cannotBeEmptyMsg = "Warning!!!, %s cannot be empty!!!, Please try again",cannotBeEmpty;
        conn = DB.sql2o.open();

        //Display page
        get("/", (request, response) -> {
            response.redirect("/employees");
            return null;
        });
        //post new department
        post("/departments/new", "application/json", (req, res) -> { // here we accept a request in JSON
            Department department = gson.fromJson(req.body(), Department.class);
            if (department == null){
                throw new ApiException(404, String.format(cannotBeEmptyMsg,"Department"));
            }
            departmentDao.add(department);
            res.type("application/json");
            res.status(201);// update the response status code
            return gson.toJson(department);
        });

        //add news to department
        post("/departments/:id/news/new", "application/json", (req, res) -> {
            int department_id = Integer.parseInt(req.params("department_id"));
            News news = gson.fromJson(req.body(), News.class);
            news.setDepartment_id(department_id);
            newsDao.add(news);
            res.status(201);
            res.type("application/json");
            return gson.toJson(news);
        });

        //get all departments
        get("/departments", "application/json", (req, res) -> { //accept a request in format JSON from an app
            res.type("application/json");
            return gson.toJson(departmentDao.getAll());//send it back to be displayed
        });

        // get all employees
        get("/employees", "application/json", (req, res) -> { //accept a request in format JSON from an app
            res.type("application/json");
            return gson.toJson(employeeDao.getAll());//send it back to be displayed
        });

        // get Employee by id
        get("/employees/:id", "application/json", (req, res) -> {
            res.type("application/json");
            int id = Integer.parseInt(req.params("id"));
            res.type("application/json");
            return gson.toJson(employeeDao.findById(id));
        });

        //find department by id
        get("/departments/:id", "application/json", (req, res) -> {
            res.type("application/json");
            int id = Integer.parseInt(req.params("id"));
            res.type("application/json");
            return gson.toJson(departmentDao.findById(id));
        });

        //get news by department id
        get("/departments/:id/news", "application/json", (req, res) -> {
            res.type("application/json");
            int department_id = Integer.parseInt(req.params("id"));
            res.type("application/json");
            return gson.toJson(newsDao.getAllNewsByDepartment(department_id));
        });

        //get employees in a department
        get("/departments/:id/employees", "application/json", (req, res) -> {
            res.type("application/json");
            int department_id = Integer.parseInt(req.params("id"));
            res.type("application/json");
            return gson.toJson(employeeDao.getAllEmployeesByDepartment(department_id));
        });

        //create new employee
        post("/employees/new", "application/json", (req, res) -> {
            Employee employee = gson.fromJson(req.body(), Employee.class);
            employeeDao.add(employee);
            res.type("application/json");
            res.status(201);
            return gson.toJson(employee);
        });

        // create news
        post("/news/new", "application/json", (req, res) -> {
            News news = gson.fromJson(req.body(), News.class);
            newsDao.add(news);
            res.type("application/json");
            res.status(201);
            return gson.toJson(news);
        });

        //get all News
        get("/news", "application/json", (req, res) -> { //accept a request in format JSON from an app
            res.type("application/json");
            return gson.toJson(newsDao.getAll());//send it back to be displayed
        });
        // get News by id
        get("/news/:id", "application/json", (req, res) -> {
            res.type("application/json");
            int id = Integer.parseInt(req.params("id"));
            res.type("application/json");
            return gson.toJson(newsDao.findById(id));
        });
    }
}