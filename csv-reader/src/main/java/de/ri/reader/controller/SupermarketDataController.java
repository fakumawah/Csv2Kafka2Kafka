package de.ri.reader.controller;

import de.ri.reader.model.SupermarketData;
import de.ri.reader.producer.SupermarketDataClient;
import de.ri.reader.service.InMemoryRepository;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Controller("supermarkets")
public class SupermarketDataController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Inject
    InMemoryRepository repository;

    @Inject
    SupermarketDataClient producer;

    @Get("/")
    public void save(){
        // Read from csv
        long start = System.nanoTime();
        File csvFile = new File("src/main/resources/supermarkt_data.csv").getAbsoluteFile();
        Path pathInput = Paths.get(csvFile.getAbsolutePath());
        List<SupermarketData> list = readFromCsv(pathInput);
        long stop = System.nanoTime();
        // Time.
        long elapsed = (stop - start);
        Duration d = Duration.ofNanos(elapsed);

        // save in memory and kafka
        list.stream().forEach(supermarketData -> repository.save(supermarketData));
        list.stream().forEach(supermarketData -> producer.sendSupermarketData(supermarketData.getId(), supermarketData));
    }

    private List<SupermarketData> readFromCsv(final Path path) {
        // TODO: Add a check for valid file existing.
        List<SupermarketData> list = List.of();  // Default to empty list.
        try {
            // Prepare list.
            int initialCapacity = (int) Files.lines(path).count();
            list = new ArrayList<>(initialCapacity);

            // Read CSV file. For each row, instantiate and collect `SupermarketData`.
            BufferedReader reader = Files.newBufferedReader(path);
            CSVFormat format = CSVFormat.newFormat(';').withFirstRecordAsHeader();
            Iterable<CSVRecord> records = format.parse(reader);
            for (CSVRecord record : records) {
                UUID id = UUID.randomUUID();
                String filiaal_num = record.get("FILIAAL_NUM");
                String datum = record.get("DATUM");
                String tijdstip = record.get("TIJDSTIP");
                String klant_num = record.get("KLANT_NUM");
                String nasa_num = record.get("NASA_NUM");
                String omsch = record.get("OMSCH");
                String inhoud_aantal = record.get("INHOUD_AANTAL");
                String eenheid = record.get("EENHEID");
                String ce_aantal = record.get("CE_AANTAL");

                // Instantiate `SupermarketData` object, and collect it.
                SupermarketData supermarketData = new SupermarketData(id.toString(), filiaal_num, datum, tijdstip, klant_num, nasa_num, omsch, inhoud_aantal, eenheid, ce_aantal);
                list.add(supermarketData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
