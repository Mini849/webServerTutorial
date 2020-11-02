package com.web.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class TemplateConfig  implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/download").setViewName("download");

        registry.addViewController("/history").setViewName("history");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/layout").setViewName("layout");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/manual").setViewName("manual");
        registry.addViewController("/resultTable").setViewName("resultTable");
        registry.addViewController("/1.1_Tool_description").setViewName("1_General_Information/1.1_Tool_description");
        registry.addViewController("/1.2_Purpose_and_main_use_case").setViewName("1_General_Information/1.2_Purpose_and_main_use_case");
        registry.addViewController("/1.3_Interface").setViewName("1_General_Information/1.3_Interface");
        registry.addViewController("/1.4_Abbreviations_used").setViewName("1_General_Information/1.4_Abbreviations_used");
        registry.addViewController("/1.5_Risks_associated_with_using_the_tool").setViewName("1_General_Information/1.5_Risks_associated_with_using_the_tool");
        registry.addViewController("/1_General_Information1").setViewName("1_General_Information/1_General_Information1");
        registry.addViewController("/1.3.1_Symbols_and_Icons_used").setViewName("1_General_Information/1.3/1.3.1_Symbols_and_Icons_used");
        registry.addViewController("/1.3.2_Example_screen").setViewName("1_General_Information/1.3/1.3.2_Example_screen");
        registry.addViewController("/2.1_Light_Approach").setViewName("2_Calculation_approaches_options/2.1_Light_Approach");
        registry.addViewController("/2.2_FFG_Approach").setViewName("2_Calculation_approaches_options/2.2_FFG_Approach");
        registry.addViewController("/2_Calculation_approaches_options").setViewName("2_Calculation_approaches_options/2_Calculation_approaches_options");
        registry.addViewController("/3.10_PVC").setViewName("3_Calculation_process/3.10_PVC");
        registry.addViewController("/3.11_Results_sheet").setViewName("3_Calculation_process/3.11_Results_sheet");
        registry.addViewController("/3.1_Base_inputs").setViewName("3_Calculation_process/3.1_Base_inputs");
        registry.addViewController("/3.2_DPCPS").setViewName("3_Calculation_process/3.2_DPCPS");
        registry.addViewController("/3.3_IPCPS").setViewName("3_Calculation_process/3.3_IPCPS");
        registry.addViewController("/3.4_IPCCF").setViewName("3_Calculation_process/3.4_IPCCF");
        registry.addViewController("/3.5_OPRC").setViewName("3_Calculation_process/3.5_OPRC");
        registry.addViewController("/3.6_MCFTH").setViewName("3_Calculation_process/3.6_MCFTH");
        registry.addViewController("/3.7_Scrap").setViewName("3_Calculation_process/3.7_Scrap");
        registry.addViewController("/3.8_PC").setViewName("3_Calculation_process/3.8_PC");
        registry.addViewController("/3.9_TS").setViewName("3_Calculation_process/3.9_TS");
        registry.addViewController("/3_Calculation_process").setViewName("3_Calculation_process/3_Calculation_process");
        registry.addViewController("/3.1.1_Setting_up_the_calculation_approach").setViewName("3_Calculation_process/3.1/3.1.1_Setting_up_the_calculation_approach");
        registry.addViewController("/3.1.2_Understanding_the_structure").setViewName("3_Calculation_process/3.1/3.1.2_Understanding_the_structure");
        registry.addViewController("/3.1.3_Special_inputs").setViewName("3_Calculation_process/3.1/3.1.3_Special_inputs");
        registry.addViewController("/3.10.1 PVC - Light and FFG approac").setViewName("3_Calculation_process/3.10/3.10.1 PVC - Light and FFG approac");
        registry.addViewController("/3.10.2 PVC - Formulas").setViewName("3_Calculation_process/3.10/3.10.2 PVC - Formulas");
        registry.addViewController("/3.10.3 PVC PPE Table").setViewName("3_Calculation_process/3.10/3.10.3 PVC PPE Table");
        registry.addViewController("/3.2.1_DPCPS_Manual").setViewName("3_Calculation_process/3.2/3.2.1_DPCPS_Manual");
        registry.addViewController("/3.2.2_DPCPS_Automatic").setViewName("3_Calculation_process/3.2/3.2.2_DPCPS_Automatic");
        registry.addViewController("/3.2.3_DPCPS_Mixed").setViewName("3_Calculation_process/3.2/3.2.3_DPCPS_Mixed");
        registry.addViewController("/3.3.1_IPCPS_Light_Approach_Manual").setViewName("3_Calculation_process/3.3/3.3.1_IPCPS_Light_Approach_Manual");
        registry.addViewController("/3.3.2_IPCPS_Light_Approach_Automatic").setViewName("3_Calculation_process/3.3/3.3.2_IPCPS_Light_Approach_Automatic");
        registry.addViewController("/3.3.3_IPCPS_FFG").setViewName("3_Calculation_process/3.3/3.3.3_IPCPS_FFG");
        registry.addViewController("/3.4.1_IPCCF_Light_Approach_Manual").setViewName("3_Calculation_process/3.4/3.4.1_IPCCF_Light_Approach_Manual");
        registry.addViewController("/3.4.2_IPCCF_Light_Approach_Automatic").setViewName("3_Calculation_process/3.4/3.4.2_IPCCF_Light_Approach_Automatic");
        registry.addViewController("/3.4.3_IPCCF_FFG").setViewName("3_Calculation_process/3.4/3.4.3_IPCCF_FFG");
        registry.addViewController("/3.5.1_OPRC_-_Light_and_FFG_approach").setViewName("3_Calculation_process/3.5/3.5.1_OPRC_-_Light_and_FFG_approach");
        registry.addViewController("/3.5.2_OPRC_-_Formulas").setViewName("3_Calculation_process/3.5/3.5.2_OPRC_-_Formulas");
        registry.addViewController("/3.6.1_MCFTH_-_Calculation").setViewName("3_Calculation_process/3.6/3.6.1_MCFTH_-_Calculation");
        registry.addViewController("/3.7.1_Scrap_-_Light_and_FFG_approach").setViewName("3_Calculation_process/3.7/3.7.1_Scrap_-_Light_and_FFG_approach");
        registry.addViewController("/3.7.2_Scrap_-_Formulas").setViewName("3_Calculation_process/3.7/3.7.2_Scrap_-_Formulas");
        registry.addViewController("/3.8.1_PC_-_Light_and_FFG_approach").setViewName("3_Calculation_process/3.8/3.8.1_PC_-_Light_and_FFG_approach");
        registry.addViewController("/3.8.2_PC_-_Formulas").setViewName("3_Calculation_process/3.8/3.8.2_PC_-_Formulas");
        registry.addViewController("/3.9.1_TS_-_Light_and_FFG_approach").setViewName("3_Calculation_process/3.9/3.9.1_TS_-_Light_and_FFG_approach");
        registry.addViewController("/3.9.2_TS_-_Formulas").setViewName("3_Calculation_process/3.9/3.9.2_TS_-_Formulas");
        registry.addViewController("/4_Quick_Guide").setViewName("4_Quick_Guide/4_Quick_Guide");








    }
}
