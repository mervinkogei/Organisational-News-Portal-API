package dao;

import models.News;

import java.util.List;

public interface NewsDao {
    void add(News news);

    //List News
    List<News> getAll();

    //Find By Id
    News findById (int id);

    //List News On Departmental Level
    List<News>getAllNewsByDepartment(int department_id);

    //Update News
    void update(int id,String title, String content, String writtenBy, int department_id);

    //Delete News
    void deleteById(int id);

    //Clear All News
    void clearAll();
}
