import com.Horse;
import com.Person;
import com.Vehicles;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Person person = new Person("唐僧",Horse.getHorse());
       // person.passRiver();
        person.passRoad();
        person.passMountain();
    }
}


