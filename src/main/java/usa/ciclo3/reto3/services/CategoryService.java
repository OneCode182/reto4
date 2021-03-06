/** < - - - - - - - - {  } - - - - - - - - > */

package usa.ciclo3.reto3.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.ciclo3.reto3.models.Category;
import usa.ciclo3.reto3.repositories.CategoryRepo;


@Service
public class CategoryService {
    
    /** < - - - - - - - - { Atributos } - - - - - - - - > */
    
    @Autowired
    private CategoryRepo metodosCrud;
    
    
    
    
    /** < - - - - - - - - { Metodos } - - - - - - - - > */
    
    public List<Category> getAll() {
        return metodosCrud.getAll();
    }
    
    public Optional<Category> getCategory(int categoryId) {
        return metodosCrud.getCategory(categoryId);
    }
    
    public Category save(Category category) {
        if (category.getId()== null) {
            return metodosCrud.save(category);
            
        } else {
            Optional<Category> evt = metodosCrud.getCategory(category.getId());
            
            if (evt.isEmpty()) {
                return metodosCrud.save(category);
                
            } else {
                return category;
                
            }
            
        }
        
    }
    
    public Category update(Category category){
        if(category.getId() != null){
            Optional<Category> g = metodosCrud.getCategory(category.getId());
            
            if(!g.isEmpty()){
                if(category.getName() != null){
                    g.get().setName(category.getName());
                }
                
                if(category.getDescription()!= null){
                    g.get().setDescription(category.getDescription());
                }
                
                return metodosCrud.save(g.get());
                
            }else{
                return category;
                
            }
            
        }else{
            return category;
            
        }
        
    }
    
    public boolean deleteCategory(int categoryId) {
        Boolean d = getCategory(categoryId).map(category -> {
            
            metodosCrud.delete(category);
            return true;
            
        }).orElse(false);
        
        return d;
        
    }
    
}


