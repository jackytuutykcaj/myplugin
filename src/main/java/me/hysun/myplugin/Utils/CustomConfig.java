package me.hysun.myplugin.Utils;

import me.hysun.myplugin.Myplugin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class CustomConfig {
    private static File file;
    private static FileConfiguration customFile;

    public static void checkIfFileExists(Myplugin plugin, UUID player_UUID, String dir, String filename){
        file = new File(dir, filename);
        if(!file.exists()){
            try{
                file.createNewFile();
            }catch (IOException e){

            }
        }
        customFile = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get(){
        return customFile;
    }

    public static void save(){
        try {
            customFile.save(file);
        } catch (IOException e) {
            System.out.println("Could not save file");
        }
    }
}
