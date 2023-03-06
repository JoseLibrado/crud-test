package com.apipostgressql.apipostgressql.controller;

import com.apipostgressql.apipostgressql.entity.CreatePolicyEntity;
import com.apipostgressql.apipostgressql.entity.Policy;
import com.apipostgressql.apipostgressql.entity.UpdatePolicy;
import com.apipostgressql.apipostgressql.pojo.DataPolizy;
import com.apipostgressql.apipostgressql.pojo.DeletePolicy;
import com.apipostgressql.apipostgressql.pojo.PoliciesPojo;
import com.apipostgressql.apipostgressql.repository.PolicyRepository;
import com.apipostgressql.apipostgressql.service.PolicyService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/service/policies")
public class PolicyController {

    private final Log LOGGER = LogFactory.getLog(PolicyController.class);

    private PolicyService policyService;

    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }

//    @CrossOrigin(origins = "http://localhost:5500/")
    @GetMapping("/retrieve-policies")
    ResponseEntity<String> getPolicies(@RequestParam int tipoQ, @RequestParam int idPolicy) {
        List<PoliciesPojo> response = policyService.getPolicies(tipoQ, idPolicy);
        LOGGER.info("lista de polizas: " + response.toString());

        try {
            return ResponseEntity.status(HttpStatus.OK).body("{\n" +
                    "    \"Meta\": {\n" +
                    "        \"Status\": \"OK\"\n" +
                    "    },\n" +
                    "    \"Data\": {\n" +
                    "        \"Poliza\": {\n" +
                    "            \"IDPoliza\": " + response.get(0).getId_policy_data() + ",\n" +
                    "            \"Cantidad\": " + response.get(0).getAmount_data() + "\n" +
                    "        },\n" +
                    "        \"Empleado\": {\n" +
                    "            \"Nombre\": \"" + response.get(0).getEmployee_first_name_data() + "\",\n" +
                    "            \"Apellido\": \"" + response.get(0).getEmployee_last_name_data() +"\"\n" +
                    "        },\n" +
                    "        \"DetalleArticulo\": {\n" +
                    "            \"SKU\": \"" + response.get(0).getSku_data() + "\",\n" +
                    "            \"Nombre\": \"" + response.get(0).getItem_name_data() + "\"\n" +
                    "        }\n" +
                    "    }\n" +
                    "}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).body("{\n" +
                    "    \"Meta\": {\n" +
                    "        \"Status\": \"FAILURE\"\n" +
                    "    },\n" +
                    "    \"Data\": {\n" +
                    "        \"Mensaje\": \"Ha ocurrido un error al consultar la póliza.\"\n" +
                    "    }\n" +
                    "}");
        }
    }

//    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @PostMapping("/create-policy")
    ResponseEntity<String> createPo(@RequestBody CreatePolicyEntity createPolicyEntity) {
        List<DataPolizy> response = policyService.createPolicy(createPolicyEntity);
        LOGGER.info("poliza generada: " + response.toString());
        try {
            return ResponseEntity.status(HttpStatus.OK).body("{\n" +
                    "    \"Meta\": {\n" +
                    "        \"Status\": \"" + "OK" + "\"\n" +
                    "    },\n" +
                    "    \"Data\": {\n" +
                    "        \"Poliza\": {\n" +
                    "            \"IDPoliza\": "  + response.get(0).getId_policy_data() +",\n" +
                    "            \"Cantidad\": "  + response.get(0).getAmount_data() +"\n" +
                    "        },\n" +
                    "        \"Empleado\": {\n" +
                    "            \"Nombre\": \""  + response.get(0).getEmployee_first_name_data() +"\",\n" +
                    "            \"Apellido\": \""  + response.get(0).getEmployee_last_name_data() +"\"\n" +
                    "        },\n" +
                    "        \"DetalleArticulo\": {\n" +
                    "            \"SKU\": \""  + response.get(0).getSku_data() +"\",\n" +
                    "            \"Nombre\": \""  + response.get(0).getItem_name_data() +"\"\n" +
                    "        }\n" +
                    "    }\n" +
                    "}");
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).body("{\n" +
                    "    \"Meta\": {\n" +
                    "        \"Status\": \"FAILURE\"\n" +
                    "    },\n" +
                    "    \"Data\": {\n" +
                    "        \"Mensaje\": \"Ha ocurrido un error en los grabados de póliza.\"\n" +
                    "    }\n" +
                    "}");
        }

    }

//    @CrossOrigin(origins = "http://127.0.0.1:5500/")
    @PutMapping("/update-policy/{id}")
    ResponseEntity<String> updatePolicy(@RequestBody UpdatePolicy updatePolicy, @PathVariable int id){
        List<com.apipostgressql.apipostgressql.pojo.UpdatePolicy> response = policyService.updatePolicy(updatePolicy,id);
        try{
            return ResponseEntity.status(HttpStatus.OK).body("{\n" +
                    "    \"Meta\": {\n" +
                    "        \"Status\": \"OK\"\n" +
                    "    },\n" +
                    "    \"Data\": {\n" +
                    "        \"Mensaje\": {\n" +
                    "            \"IDMensaje\": \"Se actualizó correctamente la poliza ## " + response.get(0).getIdPolicy() + "\"\n" +
                    "        }\n" +
                    "    }\n" +
                    "}\n");
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).body("{\n" +
                    "    \"Meta\": {\n" +
                    "        \"Status\": \"FAILURE\"\n" +
                    "    },\n" +
                    "    \"Data\": {\n" +
                    "        \"Mensaje\": \"Ha ocurrido un error al intentar actualizar la póliza.\"\n" +
                    "    }\n" +
                    "}");
        }

    }

//    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @DeleteMapping("/delete-policy/{id}")
    ResponseEntity<String> deletePolicy(@PathVariable int id){
        List<DeletePolicy> response = policyService.deletePolicy(id);
        try {
            return ResponseEntity.status(HttpStatus.OK).body("{\n" +
                    "    \"Meta\": {\n" +
                    "        \"Status\": \"OK\"\n" +
                    "    },\n" +
                    "    \"Data\": {\n" +
                    "        \"Mensaje\": {\n" +
                    "            \"IDMensaje\": \"Se eliminó correctamente la poliza ## " + response.get(0).getIdPolicy() + "\"\n" +
                    "        }\n" +
                    "    }\n" +
                    "}");
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY).body("{\n" +
                    "    \"Meta\": {\n" +
                    "        \"Status\": \"FAILURE\"\n" +
                    "    },\n" +
                    "    \"Data\": {\n" +
                    "        \"Mensaje\": \"Ha ocurrido un error al intentar eliminar la póliza.\"\n" +
                    "    }\n" +
                    "}\n");
        }
    }
}
