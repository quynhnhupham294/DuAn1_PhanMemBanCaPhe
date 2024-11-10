package DAO;

import java.util.ArrayList;
import java.util.List;

public interface DAO<Entity,Type>{
    public List<Entity> getAllData();
    public Entity getDataById(Type ma);
    public void insertData(Entity o);
    public void updateData(Entity o);
    public void deleteById(Type ma);
    public ArrayList<Type> SelectBySql(String sql,Object...args); // Quỳnh thêm
}
