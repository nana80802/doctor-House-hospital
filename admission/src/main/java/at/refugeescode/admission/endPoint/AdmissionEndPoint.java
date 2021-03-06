package at.refugeescode.admission.endPoint;

import at.refugeescode.admission.model.Patient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RestController
@RequestMapping("/patients")
public class AdmissionEndPoint {
    private RestTemplate restTemplate;

    @Value("${diagnose.url}")
    private String diagnoseUrl;

    public AdmissionEndPoint(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping
    void getPatient(@RequestBody Patient patient){
        patient.setId(UUID.randomUUID().toString());
        restTemplate.postForEntity(diagnoseUrl, patient, void.class);
    }
}
