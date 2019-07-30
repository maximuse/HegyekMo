package hu.nyirszikszi;

import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.*;

class Actions {
    static ArrayList<Hegyek> fileToList(String fileName) {
        ArrayList<Hegyek> list = new ArrayList<>();

        try {
            RandomAccessFile raf = new RandomAccessFile(fileName, "r");
            String row = raf.readLine();
            row = raf.readLine();
            String[] slice;

            while (row != null) {
                slice = new String(row.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8).split(";");

                list.add(new Hegyek(slice[0], slice[1], Integer.parseInt(slice[2])));

                row = raf.readLine();
            }

            raf.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    static String task3(ArrayList<Hegyek> list) {
        return "Hegycsúcsok száma: " + list.size() + " db";
    }

    static String task4(ArrayList<Hegyek> list) {
        double sum = 0;
        double avg;

        for (Hegyek hegyek : list) {
            sum += hegyek.getMagassag();
        }

        avg = sum / list.size();

        return "Hegycsúcsok átlagos magassága: " + String.format("%.2f", avg) + " m";
    }

    static String task5(ArrayList<Hegyek> list) {
        String result = "A legmamasabb hegycsúcs adatai:";
        int index = 0;
        int height = list.get(index).getMagassag();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMagassag() > height) {
                index = i;
                height = list.get(i).getMagassag();
            }
        }

        result += "\n\tNév: " + list.get(index).getHegycsucsNeve() +
                  "\n\tHegység: " + list.get(index).getHegyseg() +
                  "\n\tMagasság: " + list.get(index).getMagassag() + " m";

        return result;
    }

    static String task6(ArrayList<Hegyek> list) {
        String result = "";
        Scanner s = new Scanner(System.in);
        boolean isTrue = false;

        System.out.print("Kérek egy magasságot: ");
        try {
            int height = s.nextInt();

            for (Hegyek hegyek : list) {
                if (hegyek.getHegyseg().equals("Börzsöny") && hegyek.getMagassag() > height) {
                    isTrue = true;
                    break;
                }
            }

            if (isTrue) {
                result += "Van " + height + " m-nél";
            }
            else {
                result += "Nincs " + height + " m-nél";
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return result + " magasabb hegycsúcs a Börzsönyben!";
    }

    static String task7(ArrayList<Hegyek> list) {
        double ft;
        int counter = 0;

        for (Hegyek hegyek : list) {
            ft = hegyek.getMagassag() * 3.280839895;

            if (ft > 3000) {
                counter++;
            }
        }

        return "3000 lábnál magasabb hegycsúcsok száma: " + counter;
    }

    static StringBuilder task8(ArrayList<Hegyek> list) {
        StringBuilder result = new StringBuilder("Hegység statisztika");
        TreeSet<String> mounts = new TreeSet<>();
        Map<String, Integer> stat = new HashMap<>();
        int counter = 0;

        for (Hegyek hegyek : list) {
            mounts.add(hegyek.getHegyseg());
        }

        for (String mount : mounts) {
            for (Hegyek hegyek : list) {
                if (mount.equals(hegyek.getHegyseg())) {
                    counter++;
                }
            }

            stat.put(mount, counter);
            counter = 0;
        }

        stat.forEach((key, value) -> result.append("\n\t" + key + " - " + value));

        return result;
    }

    static String task9(ArrayList<Hegyek> list, String fileName) {
        ArrayList<String> results = new ArrayList<>();
        DecimalFormat sub = new DecimalFormat("##.0");
        double ftD;
        int ftI;
        String ft;

        for (Hegyek hegyek : list) {
            if (hegyek.getHegyseg().equals("Bükk-vidék")) {
                ftD = hegyek.getMagassag() * 3.280839895;
                ftI = (int)ftD;

                if (sub.format((ftD - ftI)).equals(",0")) {
                    results.add(hegyek.getHegycsucsNeve() + ";" + ftI);
                }
                else {
                    ft = String.format("%.1f", ftD).replace(',', '.');
                    results.add(hegyek.getHegycsucsNeve() + ";" + ft);
                }
            }
        }

        try {
            RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
            raf.writeBytes(new String("Hegycsúcs neve;Magassáb láb\r\n".getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1));

            for (String result : results) {
                raf.writeBytes(new String(result.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1) + "\r\n");
            }

            raf.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return fileName;
    }
}