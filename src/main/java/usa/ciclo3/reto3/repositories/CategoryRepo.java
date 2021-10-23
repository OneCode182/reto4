/** < - - - - - - - - {  } - - - - - - - - > */

package usa.ciclo3.reto3.repositories;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.ciclo3.reto3.models.Category;
import usa.ciclo3.reto3.repositories.crud.CategoryInterface;



@Repository
public class CategoryRepo {
    
    /** < - - - - - - - - { Atributos } - - - - - - - - > */
    
    @Autowired
    private CategoryInterface crud;
    
    
    
    
    /** < - - - - - - - - { Metodos } - - - - - - - - > */
    
    public List<Category> getAll() {
        return (List<Category>) crud.findAll();
    }
    
    public Optional<Category> getCategory(int id) {
        return crud.findById(id);
    }
    
    public Category save(Category category) {
        return crud.save(category);
    }
    
    public void delete(Category category) {
        crud.delete(category);
    }

}


