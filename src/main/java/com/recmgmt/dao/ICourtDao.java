import java.util.*;
public interface ICourtDao {
public void insertCourt(Court crt);
public void deleteCourt(int courtID);
public List<Court> fetchCourts();
}

