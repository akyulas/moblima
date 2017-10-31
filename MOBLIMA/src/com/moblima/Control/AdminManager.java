package com.moblima.Control;

import com.moblima.LoginSystem.Admin;
import java.util.ArrayList;

public class AdminManager {

    private ArrayList<Admin> admins;
    private String FileString = "/com/moblima/TextFiles/admin.dat";
    private ImportController importController;

    public AdminManager() {
        admins = new ArrayList<Admin>();
        importController = new ImportController();
    }

    public void importData() {
        ArrayList list = (ArrayList)importController.readSerializedObject(FileString);
        for (int i = 0; i < list.size(); i++) {
            Admin admin = (Admin)list.get(i);
            admins.add(admin);
        }
    }

    public void exportData() {
        importController.writeSerializedObject(FileString, admins);
    }

    protected void wipeOutData() {
        importController.writeSerializedObject(FileString, new ArrayList());
    }

}
