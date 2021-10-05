package ongoing.carrus.configuration;

import ongoing.carrus.entity.Car;
import ongoing.carrus.entity.Member;
import ongoing.carrus.repo.CarRepository;
import ongoing.carrus.repo.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.Date;
@Configuration
public class DataSetup implements CommandLineRunner {
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private CarRepository carRepository;

    @Override
    public void run(String... args) throws Exception {
        memberRepository.deleteAll();
        memberRepository.save(new Member("Krishna", "Khanal", "Ringertoften 6 2tv", "Copenhagen", "2400", "71552802", "k@gmail.com", false, 0, 10.0));
        memberRepository.save(new Member("Shuva", "Khanal", "Ringertoften 6 2tv", "Copenhagen", "2400", "71552802", "s@gmail.com", false, 1, 10.0));
        memberRepository.save(new Member("Sukrish", "Khanal", "Ringertoften 6 2tv", "Copenhagen", "2400", "71552802", "s1@gmail.com", false, 2, 10.0));
        carRepository.deleteAll();
        carRepository.save(new Car("CHR", "ch-2019", "Toyota", true, false, 300.0));
        carRepository.save(new Car("Yaris", "Ya-2019", "Toyota", false, true, 300.0));
        carRepository.save(new Car("T-cross","T-2020","VolksWagen",true, false,500.0));

    }
}
