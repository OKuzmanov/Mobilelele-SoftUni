package bg.softuni.mobilelele.init;

import bg.softuni.mobilelele.models.entities.*;
import bg.softuni.mobilelele.models.enums.CategoryEnum;
import bg.softuni.mobilelele.models.enums.EngineEnum;
import bg.softuni.mobilelele.models.enums.RoleEnum;
import bg.softuni.mobilelele.models.enums.TransmissionEnum;
import bg.softuni.mobilelele.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRoleService userRoleService;
    private final UserService userService;
    private final BrandService brandService;
    private final ModelService modelService;
    private final OfferService offerService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DataInitializer(UserRoleService userRoleService, UserService userService, BrandService brandService, ModelService modelService, OfferService offerService, PasswordEncoder passwordEncoder) {
        this.userRoleService = userRoleService;
        this.userService = userService;
        this.brandService = brandService;
        this.modelService = modelService;
        this.offerService = offerService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {

        populateDatabase();

    }

    private void populateDatabase() {
        UserRole adminRole = new UserRole(RoleEnum.ADMIN);
        UserRole userRole = new UserRole(RoleEnum.USER);

        this.userRoleService.save(adminRole);
        this.userRoleService.save(userRole);

        User testUser1 = new User("pesho1", passwordEncoder.encode("01234"), "Pesho", "Peshev", adminRole, "demoImageUrl", true);
        User testUser2 = new User("vanko1", passwordEncoder.encode("091011"), "Ivan", "Ivanovski", userRole, "demoImageUrl", true);

        this.userService.save(testUser1);
        this.userService.save(testUser2);

        Brand ford = new Brand("Ford");
        this.brandService.save(ford);

        Model fiesta = new Model("Fiesta", CategoryEnum.CAR,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg/420px-2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg",
                1976, ford);

        Model focus = new Model("Focus", CategoryEnum.CAR,
                "https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/2018_Ford_Focus_ST-Line_X_1.0.jpg/420px-2018_Ford_Focus_ST-Line_X_1.0.jpg",
                1998, ford);

        modelService.save(fiesta);
        modelService.save(focus);

        Offer testOffer1 = new Offer("testDescription", EngineEnum.DIESEL, "testImageUrl", 150000, BigDecimal.valueOf(15000.00), TransmissionEnum.MANUAL, 2008, focus, testUser1);
        Offer testOffer2 = new Offer("testDescription", EngineEnum.GASOLINE, "testImageUrl2", 130000, BigDecimal.valueOf(12000.00), TransmissionEnum.AUTOMATIC, 2004, fiesta, testUser2);

        offerService.save(testOffer1);
        offerService.save(testOffer2);
    }
}
