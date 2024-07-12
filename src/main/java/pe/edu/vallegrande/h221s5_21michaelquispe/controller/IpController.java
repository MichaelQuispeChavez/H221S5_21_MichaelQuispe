package pe.edu.vallegrande.h221s5_21michaelquispe.controller;

import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.h221s5_21michaelquispe.model.IpQuery;
import pe.edu.vallegrande.h221s5_21michaelquispe.service.IpService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1")
public class IpController {
    private final IpService ipService;

    public IpController(IpService ipService) {
        this.ipService = ipService;
    }

    @GetMapping("/miIp")
    public Mono<IpQuery> cualEsMiIp() {
        return ipService.cualEsMiIp();
    }

    @GetMapping("/detalle")
    public Mono<IpQuery> getIpInfo() {
        return ipService.ipDetalle();
    }

    @GetMapping("/consulta/{ip}")
    public Mono<IpQuery> consultaIpExterna(@PathVariable String ip) {
        return ipService.consultaIpExterna(ip);
    }
}
