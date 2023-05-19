package Controller;

import Models.CarteModel;
import Views.CarteView;


public class CarteController {
    private CarteModel carteModel;
    private CarteView carteView;


    public CarteController(CarteModel carteModel) {
        this.carteModel = carteModel;
        this.carteView = new CarteView(carteModel);
    }

    public void updateCarteTitle(String newTitle) {
        carteModel.setTitreCarte(newTitle);
        carteView.updateTitle(newTitle);
    }

    public void updateCarteDescription(String newDescription) {
        carteModel.setDescription(newDescription);
        carteView.updateDescription(newDescription);
    }

    // Other methods for handling Carte operations and interactions
}