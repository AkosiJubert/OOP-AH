/*
 * Programmer: H2101 GROUP 14 | Franco, C., Jardeliza, L., Lasic, J.
 * Date: March 2026
 * Project: MotorPH Payroll System
 */

package repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AttendanceRepository {

    private static final String FILE_PATH = "src/resources/attendance_record.csv";

    private final DateTimeFormatter csvDateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    private final DateTimeFormatter csvTimeFormat = DateTimeFormatter.ofPattern("H:mm"); // supports 8:30

    // Returns total hours worked within the date range for one employee
    public double getHoursWorked(int employeeId, LocalDate start, LocalDate end) {

        double totalHours = 0.0;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {

            br.readLine(); // skip header

            String line;
            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");
                if (data.length < 6) continue;

                int id;
                try {
                    id = Integer.parseInt(data[0].trim());
                } catch (NumberFormatException e) {
                    continue;
                }

                if (id != employeeId) continue;

                LocalDate date;
                try {
                    date = LocalDate.parse(data[3].trim(), csvDateFormat);
                } catch (Exception e) {
                    continue;
                }

                if (date.isBefore(start) || date.isAfter(end)) continue;

                LocalTime timeIn;
                LocalTime timeOut;
                try {
                    timeIn = LocalTime.parse(data[4].trim(), csvTimeFormat);
                    timeOut = LocalTime.parse(data[5].trim(), csvTimeFormat);
                } catch (Exception e) {
                    continue;
                }

                double hours = (timeOut.toSecondOfDay() - timeIn.toSecondOfDay()) / 3600.0;
                if (hours < 0) continue;

                totalHours += hours;
            }

        } catch (IOException e) {
            return 0.0;
        }

        return totalHours;
    }
}

