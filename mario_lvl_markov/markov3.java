package levelGenerators.random;

import engine.core.MarioLevelModel;
import engine.helper.MarioTimer;
import engine.helper.RunUtils;
import levelGenerators.MarioLevelGenerator;

import java.util.HashMap;
import java.util.Random;

public class markov3 implements MarioLevelGenerator {
    private int FLOOR_PADDING = 3;
    @Override
    public String getGeneratedLevel(MarioLevelModel model, MarioTimer timer) {
        model.clearMap();
        String storelvl[][] = getColumnArray();
        HashMap<String, char[]> skymap = new HashMap<String, char[]>();
        HashMap<String, char[]> imap = new HashMap<String, char[]>();
        HashMap<String, char[]> gmap = new HashMap<String, char[]>();
        for(int i=0;i<storelvl.length;i++)
        {
            int size = storelvl[i].length;
            int charactercount = 1;
            for(int j=1;j<size;j++)
            {
                String pattern = String.valueOf(storelvl[i][j].charAt(charactercount-1)) + String.valueOf(storelvl[i][j-1].charAt(charactercount));
                charactercount++;
                char next = storelvl[i][j].charAt(charactercount);
                if (j >= 1 && j <= 6) {
                    if (skymap.containsKey(pattern)) {
                        String st1 = String.valueOf(skymap.get(pattern));
                        st1 = st1 + next;
                        skymap.remove(pattern);
                        skymap.put(pattern, st1.toCharArray());
                    } else {
                        char c[] = {next};
                        skymap.put(pattern, c);
                    }
                }//END IF 1-6

                if (j >= 7 && j <= 11) {
                    if (imap.containsKey(pattern)) {
                        String st1 = String.valueOf(imap.get(pattern));
                        st1 = st1 + next;
                        imap.remove(pattern);
                        imap.put(pattern, st1.toCharArray());
                    } else {
                        char c[] = {next};
                        imap.put(pattern, c);
                    }
                }//END IF 7-12
                if (j >= 12 && j <= 15) {
                    if (gmap.containsKey(pattern)) {
                        String st1 = String.valueOf(gmap.get(pattern));
                        st1 = st1 + next;
                        gmap.remove(pattern);
                        gmap.put(pattern, st1.toCharArray());
                    } else {
                        char c[] = {next};
                        gmap.put(pattern, c);
                    }
                }//END IF 13-15
            }//END FOR j

        }//END FOR i

        for (int x = 1; x < model.getWidth(); x++) {
            for (int y = 1; y < model.getHeight(); y++) {
                Random random = new Random();
                String target = String.valueOf(model.getBlock(x, y)) + String.valueOf(model.getBlock(x - 1, y - 1));
                System.out.println(target);
                if (y >= 0 && y <= 6) {
                    if (skymap.containsKey(target)) {
                        char c[] = skymap.get(target);
                        int size = c.length;
                        int val = random.nextInt(size);
                        model.setBlock(x, y, c[val]);

                    }
                }//END IF 0-6
                if (y >= 7 && y <= 11) {
                    if (imap.containsKey(target)) {
                        char c[] = imap.get(target);
                        int size = c.length;
                        int val = random.nextInt(size);
                        model.setBlock(x, y, c[val]);

                    }
                }//END IF 7-12
                if (y >= 12 && y <= 15) {
                    if (gmap.containsKey(target)) {
                        char c[] = gmap.get(target);
                        int size = c.length;
                        int val = random.nextInt(size);
                        model.setBlock(x, y, c[val]);

                    }
                }//END IF 13-15
            }//END Y
        }//END X
        model.setRectangle(0, 14, FLOOR_PADDING, 2, MarioLevelModel.GROUND);
        model.setRectangle(model.getWidth() - 1 - FLOOR_PADDING, 14, FLOOR_PADDING, 2, MarioLevelModel.GROUND);
        model.setBlock(FLOOR_PADDING / 2, 13, MarioLevelModel.MARIO_START);
        model.setBlock(model.getWidth() - 1 - FLOOR_PADDING / 2, 13, MarioLevelModel.MARIO_EXIT);
for (String key:skymap.keySet())
{
    System.out.println(key);
    System.out.println(skymap.get(key));
}
        for (String key:imap.keySet())
        {
            System.out.println(key);
            System.out.println(imap.get(key));
        }
        for (String key:gmap.keySet())
        {
            System.out.println(key);
            System.out.println(gmap.get(key));
        }
        return model.getMap();
    }//END getgeneratedlevel

    @Override
    public String getGeneratorName() {




        return "Markov 3";
    }//END GET GENERATOR NAME

    public String[][] getColumnArray()
    {
        int numOfLvls = 15;
        String lvlarr[] = new String[numOfLvls];
        //String[][] lvlstore = new String[][];
        int levelcount =0;
        for(int i=1;i<=numOfLvls;i++)
        {
            lvlarr[levelcount] = RunUtils.retrieveLevel("levels/original/lvl-"+i+".txt");

            levelcount++;
        }
        String lvlstore[][]= new String[numOfLvls][16]; //each level has 16 rows
        for(int i=0;i<numOfLvls;i++)
        {
            String temp2[] = lvlarr[i].split("\n");
            //System.out.println(temp2.length);
            for (int x=0;x<temp2.length;x++)
            {
                lvlstore[i][x] = temp2[x];
                //System.out.println(lvlstore[i][x]);
            }
        }
        return lvlstore;
    }
}
