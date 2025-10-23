import java.io.*;
import java.nio.file.*;
import java.util.*;

public class AidShipManager {
    private final ArrayList<AidShip> aidShipList = new ArrayList<>();
    private Path dataPath = Paths.get("data", "aidships.csv"); // adjust file name if different

    public ArrayList<AidShip> getAidShipList() {
        return aidShipList;
    }

    public void setDataPath(String fileName) {
        this.dataPath = Paths.get("data", fileName);
    }

    public void loadAidShips() throws IOException {
        aidShipList.clear();
        if (!Files.exists(dataPath)) return;

        try (BufferedReader br = Files.newBufferedReader(dataPath)) {
            String line;

            // If your CSV has a header row, uncomment the next line to skip it:
            // br.readLine();

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                AidShip ship = convertLineToAidShip(line);
                if (ship != null) aidShipList.add(ship);
            }
        }
    }

    public boolean isAidShipExists(String registrationNumber) {
        return findAidShip(registrationNumber) != null;
    }

    public AidShip findAidShip(String registrationNumber) {
        if (registrationNumber == null) return null;
        for (AidShip s : aidShipList) {
            if (registrationNumber.equalsIgnoreCase(s.getRegistrationNumber())) return s;
        }
        return null;
    }

    public boolean updateAidShip(AidShip updated) throws IOException {
        String key = updated.getRegistrationNumber();
        for (int i = 0; i < aidShipList.size(); i++) {
            if (aidShipList.get(i).getRegistrationNumber().equalsIgnoreCase(key)) {
                aidShipList.set(i, updated);
                saveDataToFile();
                return true;
            }
        }
        return false;
    }

    public boolean deleteAidShip(String registrationNumber) throws IOException {
        boolean removed = aidShipList.removeIf(s ->
                s.getRegistrationNumber().equalsIgnoreCase(registrationNumber));
        if (removed) saveDataToFile();
        return removed;
    }

    private void saveDataToFile() throws IOException {
        Files.createDirectories(dataPath.getParent());
        try (BufferedWriter bw = Files.newBufferedWriter(dataPath)) {
            // Optional header:
            // bw.write("registrationNumber,name,capacity,tonnage,crewSize,currentPort,aidType,suppliesOnBoard,hasHelipad");
            // bw.newLine();
            for (AidShip s : aidShipList) {
                bw.write(convertAidShipToLine(s));
                bw.newLine();
            }
        }
    }

    private AidShip convertLineToAidShip(String line) {
        String[] p = line.split(",", -1);
        try {
            String reg = p[0].trim();
            String name = p[1].trim();
            int capacity = Integer.parseInt(p[2].trim());
            double tonnage = Double.parseDouble(p[3].trim());
            int crewSize = Integer.parseInt(p[4].trim());
            String currentPort = p[5].trim();
            String aidType = p[6].trim();
            int suppliesOnBoard = Integer.parseInt(p[7].trim());
            boolean hasHelipad = Boolean.parseBoolean(p[8].trim());

            return new AidShip(reg, name, capacity, tonnage, crewSize, currentPort,
                    aidType, suppliesOnBoard, hasHelipad);
        } catch (Exception e) {
            System.err.println("Skipping bad line: " + line + " (" + e.getMessage() + ")");
            return null;
        }
    }

    private String convertAidShipToLine(AidShip s) {
        return String.join(",",
                s.getRegistrationNumber(),
                s.getName(),
                String.valueOf(s.getCapacity()),
                String.valueOf(s.getTonnage()),
                String.valueOf(s.getCrewSize()),
                s.getCurrentPort(),
                s.getAidType(),
                String.valueOf(s.getSuppliesOnBoard()),
                String.valueOf(s.isHasHelipad())
        );
    }
}

