package net.minecraft.src;
import java.util.*;
import java.io.*;
import net.minecraft.client.Minecraft;
import java.lang.reflect.Field;

public class mod_WTF extends BaseMod{
    public String getVersion(){
        return "1.2.4";
    }

    public mod_WTF(){
    }

    public void load(){
        moduleGui = new GuiWTFModulesList(null);
        ModLoader.registerKey(this, this.keySettings, false);
        ModLoader.addLocalization("key_settings", "Open WTF Settings");
    }
    
    public static void saveModuleProperties(int id){
        Properties properties = new Properties();
        try{
            File file = new File((new StringBuilder()).append(Minecraft.getMinecraftDir()).append("/config/WTF"+id+".properties").toString());
            FileOutputStream fileoutputstream = new FileOutputStream(file);
            for (int i = 1; i <= proplength[id]; i++){
                properties.setProperty(propfield[id][i].getName(), Boolean.toString(propvalue[id][i]));
            }
            properties.store(fileoutputstream, "WTF config");
            fileoutputstream.close();
        }
        catch(IOException ioexception){
            ioexception.printStackTrace();
        }
    }
    
    public static void loadModuleProperties(int id){
        Properties properties = new Properties();
        try{
            File file = new File((new StringBuilder()).append(Minecraft.getMinecraftDir()).append("/config/WTF"+id+".properties").toString());
            boolean flag = file.createNewFile();
            if(flag){
                FileOutputStream fileoutputstream = new FileOutputStream(file);
                for (int i = 1; i <= proplength[id]; i++){
                    properties.setProperty(propfield[id][i].getName(), Boolean.toString(propvalue[id][i]));
                }
                properties.store(fileoutputstream, "WTF config");
                fileoutputstream.close();
            }
            try{
                properties.load(new FileInputStream((new StringBuilder()).append(Minecraft.getMinecraftDir()).append("/config/WTF"+id+".properties").toString()));
                for (int i = 1; i <= proplength[id]; i++){
                    boolean val = Boolean.parseBoolean(properties.getProperty(propfield[id][i].getName()));;
                    propvalue[id][i] = val;
                    propfield[id][i].setBoolean(Class.forName(modules[id]), val);
                    sendCallback(id, i);
                }
            }catch(Exception ex){
                System.out.println(ex);
            }
        }
        catch(IOException ioexception){
            ioexception.printStackTrace();
        }
    }

    public static void addModules(GuiWTFModulesList gui){
        gui.addModule(0,"Actions");
        gui.addModule(1,"Bugs");
        gui.addModule(2,"Gameplay");
        gui.addModule(3,"Eyecandy");
    }
    
    public static void addProperty(Object module, int i2, String name, boolean val, String var){
        int i1 = 0;
        for (int i = 0; i<modules.length; i++){
            try{
                if (module.getClass() == Class.forName(modules[i])){
                    i1 = i;
                }
            }catch (Exception ex){
                try{
                    if (module.getClass() == Class.forName(modules2[i])){
                        i1 = i;
                        modules = modules2;
                    }
                }catch (Exception ex2){
                    continue;
                }
                continue;
//             if (module.getClass() == modules[i]){
//                 i1 = i;
            }
        }
        if (propname==null){
            propname=new String[10][30];
        }
        if (propvalue==null){
            propvalue=new boolean[10][30];
        }
        if (propfield==null){
            propfield=new Field[10][30];
        }
        if (proplength==null){
            proplength=new int[10];
            proplength[i1]=0;
        }
        propname[i1][i2]=name;
        propvalue[i1][i2]=val;
        try{
            propfield[i1][i2]=Class.forName(modules[i1]).getDeclaredField(var);
        }catch (Exception ex){}
//             propfield[i1][i2]=modules[i1].getDeclaredField(var);
//         }catch (Exception ex){
//             System.out.println(ex);
//         }
        proplength[i1]++;
    }

    public void keyboardEvent(KeyBinding keybinding){
        if (keybinding==keySettings){
            ModLoader.openGUI(ModLoader.getMinecraftInstance().thePlayer, moduleGui);
        }
    }
    
    public void callback (int i){}

    public static void sendCallback(int id, int i2){
        int id2 = 0;
        List list = ModLoader.getLoadedMods();
        Object obj = null;
        for(int i = 0; i < list.size(); i++){
            try{
                if (list.get(i).getClass() == Class.forName(modules[id])){
                    obj = list.get(i);
                    break;
                }
            }catch (Exception ex){
                continue;
            }
        }
        try{
            ((mod_WTF)obj).callback(i2);
        }catch (Exception ex){}
    }

    private GuiWTFModulesList moduleGui;
    public KeyBinding keySettings = new KeyBinding("key_settings", 35);
    public static String[][] propname;
    public static boolean[][] propvalue;
    public static Field[][] propfield;
    public static int[] proplength;
//     public static Class[] modules = {mod_WTFActions.class, mod_WTFBugs.class, mod_WTFGameplay.class, mod_WTFEyecandy.class, mod_WTFActions2.class};
    public static String[] modules = {"net.minecraft.src.mod_WTFActions", "net.minecraft.src.mod_WTFBugs", "net.minecraft.src.mod_WTFGameplay", "net.minecraft.src.mod_WTFEyecandy"};
    public static String[] modules2 = {"mod_WTFActions", "mod_WTFBugs", "mod_WTFGameplay", "mod_WTFEyecandy"};
}