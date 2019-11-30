package dao;

import models.News;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Sql2o;

import java.sql.Connection;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Sql2oNewsDaoTest {
    private Connection con;
    private Sql2oNewsDao newsDao;
    private Sql2oDepartmentDao departmentDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "moringa", "1234");
        newsDao = new Sql2oNewsDao(sql2o);
        departmentDao =new Sql2oDepartmentDao(sql2o);
        con = (Connection) sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        con.close();
    }
    // SetUp Helper Methods
    public News setUpNews(){
        News news = new News ("Promotion","The company is seek to promote job groups","Daily Nation","Jobs",1);
        newsDao.add(news);
        return news;
    }

    // Organisation News
    public News setUpOrgNews(){
        News organizationNews = new News ("Technology","Implementation of AI Technology","Kogei","Journal",1);
        newsDao.add(organizationNews);
        return organizationNews;
    }
    @Test
    public void add(){
        News news =setUpNews();
        assertEquals(1,newsDao.getAll().size());
    }
    @Test
    public void add_assignsId(){
        News news = setUpNews();
        assertEquals(1,news.getId());
    }
    @Test
    public void getAll_returns_organizationNews(){
        News orgNews = setUpOrgNews();
        assertEquals(1,newsDao.getAll().size());
    }
    @Test
    public void getAll(){
        News news1 = setUpNews();
        News news2 = setUpNews();
        assertEquals(2,newsDao.getAll().size());
    }
    @Test
    public void getAllNewsByDepartment(){
        News news = setUpNews();
        List<News>allNewsByDepartmentId = newsDao.getAllNewsByDepartment(news.getDepartment_id());
        assertEquals(news.getDepartment_id(),allNewsByDepartmentId.get(0).getDepartment_id());
    }
    @Test
    public void deleteById(){
        News news =setUpNews();
        News news1= setUpNews();
        assertEquals(2,newsDao.getAll().size());
        newsDao.deleteById(news.getId());
        assertEquals(1,newsDao.getAll().size());
    }
    @Test
    public void clearAll(){
        News news = setUpNews();
        News news1 = setUpNews();
        newsDao.clearAll();
        assertEquals(0,newsDao.getAll().size());
    }
}
