package com.mycompany.booking.core;

;
import com.mycompany.booking.utils.IDAO;
import java.util.List;

/**
 * Interface to competion catalogue
 * @author hajo
 * Details changed to fit our project
 */
public interface ICompetitionCatalogue extends IDAO<Competition, Long> {

     List<Competition> getByName(String name);
    
    public Object getById(Long id);
   
    public List<Competition> getByMail(String email);

    String getLnameByEmail(String email);
    
    String getFnameByEmail(String email);


}
    