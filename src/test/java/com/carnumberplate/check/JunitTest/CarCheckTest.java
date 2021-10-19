package com.carnumberplate.check.JunitTest;
import com.carnumberplate.check.pages.CarRegPage;
import com.carnumberplate.check.pages.FreeCarCheckHomePage;
import com.carnumberplate.check.utilities.DriverUtil;
import com.carnumberplate.check.utilities.ReadFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.io.IOException;
import java.util.List;


import static com.carnumberplate.check.utilities.ReadFile.carRegArr;

public class CarCheckTest extends DriverUtil {

    public CarCheckTest() {
    }

    public static String[] getCarRegArray() {
        return carRegArr;
    }

    @ParameterizedTest
    @MethodSource("getCarRegArray")
    public void validateCarReg(String args) throws IOException {
        ReadFile.outputFileReader();
        FreeCarCheckHomePage freeCarCheckHomePage = new FreeCarCheckHomePage(getDriver());
        CarRegPage carRegPage = new CarRegPage(getDriver());
        freeCarCheckHomePage.navigateToHomePage();
        System.out.println(args);
        freeCarCheckHomePage.enterVehicleRegistration(args);
        freeCarCheckHomePage.clickFreeCheckButton();
        List list = ReadFile.buildVehicleIdentity(carRegPage.getRegistration(), carRegPage.getMake(), carRegPage.getModel(), carRegPage.getColour(), carRegPage.getYear());

        ReadFile.getOutput().retainAll(list);
        System.out.println("AAAAAAAAAAAAAAA   " + ReadFile.getOutput());
        System.out.println("BBBBBBBBBBBBBBB   " + list);

        Assertions.assertTrue(ReadFile.getOutput().equals(list));
        ReadFile.getOutput().clear();
    }

}
