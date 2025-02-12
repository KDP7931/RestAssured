package com.pages;


public class TestCaseCategories {
    public String CategoryModules(String className) {
    	 String Class = "Default";// Set the default category to "Lot Actions"

        // Check if the class name belongs to a specific action
        if (className != null) {
            if (className.startsWith("com.kp.qa.ConditionScripts.")) {
                String action = className.substring("com.kp.qa.ConditionScripts.".length());

                // Print the specific action (for debugging or logging)
                System.out.println("In " + action);
                 Class = "Condition_Builder";
               
            }
        }
        
        if (className != null) {
            if (className.startsWith("com.kp.qa.scenario_builder_script.")) {
                String action = className.substring("com.kp.qa.scenario_builder_script.".length());

                // Print the specific action (for debugging or logging)
                System.out.println("In " + action);
                 Class = "Scenario_Builder";
               
            }
        }
        
        if (className != null) {
            if (className.startsWith("com.kp.qa.OperationScripts.")) {
                String action = className.substring("com.kp.qa.OperationScripts.".length());

                // Print the specific action (for debugging or logging)
                System.out.println("In " + action);
                 Class = "Operation_Modeling";
               
            }
        }
        
        
        if (className != null) {
            if (className.startsWith("com.kp.qa.InventoryandSpareParts_Scripts.")) {
                String action = className.substring("com.kp.qa.InventoryandSpareParts_Scripts.".length());

                // Print the specific action (for debugging or logging)
                System.out.println("In " + action);
                 Class = "Inventory_and_SpareParts";
               
            }
        }
        
        if (className != null) {
            if (className.startsWith("com.kp.qa.Sitemodelling_Scripts.")) {
                String action = className.substring("com.kp.qa.Sitemodelling_Scripts.".length());

                // Print the specific action (for debugging or logging)
                System.out.println("In " + action);
                 Class = "Site_Modelling";
               
            }
        }
        
        if (className != null) {
            if (className.startsWith("com.kp.qa.LotsProductsStageStepsScripts.")) {
                String action = className.substring("com.kp.qa.LotsProductsStageStepsScripts.".length());

                // Print the specific action (for debugging or logging)
                System.out.println("In " + action);
                 Class = "Lots_Products_Stage_Steps_Scripts";
               
            }
        }
        
        if (className != null) {
            if (className.startsWith("com.kp.qa.SPC_Script.")) {
                String action = className.substring("com.kp.qa.SPC_Script.".length());

                // Print the specific action (for debugging or logging)
                System.out.println("In " + action);
                 Class = "Statistical_Process_Control";
               
            }
        }
        
        if (className != null) {
            if (className.startsWith("com.kp.qa.VersionManagement_Scripts.")) {
                String action = className.substring("com.kp.qa.VersionManagement_Scripts.".length());

                // Print the specific action (for debugging or logging)
                System.out.println("In " + action);
                 Class = "Version_Management";
               
            }
        }
        
        if (className != null) {
            if (className.startsWith("com.kp.qa.VAB_Script.")) {
                String action = className.substring("com.kp.qa.VAB_Script.".length());

                // Print the specific action (for debugging or logging)
                System.out.println("In " + action);
                 Class = "Variable_Attribute_Builder";
               
            }
        }
        
        if (className != null) {
            if (className.startsWith("com.kp.qa.Activity_Modeling_Scripts.")) {
                String action = className.substring("com.kp.qa.Activity_Modeling_Scripts.".length());

                // Print the specific action (for debugging or logging)
                System.out.println("In " + action);
                 Class = "Activity_Modeling";
               
            }
        }
        
        if (className != null) {
            if (className.startsWith("com.kp.qa.UserModelingScripts.")) {
                String action = className.substring("com.kp.qa.UserModelingScripts.".length());

                // Print the specific action (for debugging or logging)
                System.out.println("In " + action);
                 Class = "User_Modeling";
               
            }
        }
        
        if (className != null) {
            if (className.startsWith("com.kp.qa.RMS_Script.")) {
                String action = className.substring("com.kp.qa.RMS_Script.".length());

                // Print the specific action (for debugging or logging)
                System.out.println("In " + action);
                 Class = "Recipe_Management_System";
               
            }
        }
        return Class;
    }
    
    
}
