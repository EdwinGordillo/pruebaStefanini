package co.com.prueba.stefanini.PruebaStefanini.dto;

import lombok.Data;
import java.util.List;

@Data
public class UsersWrapper {
    private List<UserMeDTO> users;
    private int total;
    private int skip;
    private int limit;
}