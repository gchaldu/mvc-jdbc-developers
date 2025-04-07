package org.example;

import org.example.developer.controller.DeveloperController;
import org.example.developer.exceptions.DeveloperException;
import org.example.developer.exceptions.DeveloperNotFoundException;
import org.example.developer.model.Developer;
import org.example.developer.model.DeveloperRepository;
import org.example.developer.view.DeveloperView;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DeveloperRepository developerRepository = new DeveloperRepository();
        DeveloperController developerController = new DeveloperController(developerRepository);
        DeveloperView developerView = new DeveloperView(developerController);

        developerView.showMenu();




    }
}