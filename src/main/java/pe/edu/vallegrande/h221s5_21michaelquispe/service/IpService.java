package pe.edu.vallegrande.h221s5_21michaelquispe.service;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import pe.edu.vallegrande.h221s5_21michaelquispe.model.IpQuery;
import pe.edu.vallegrande.h221s5_21michaelquispe.repository.IpQueryRepository;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class IpService {

    private final WebClient webClient;
    private final IpQueryRepository ipQueryRepository;

    public IpService(WebClient.Builder webClientBuilder, IpQueryRepository ipQueryRepository) {
        this.webClient = webClientBuilder.baseUrl("https://ipinfo.io").build();
        this.ipQueryRepository = ipQueryRepository;
    }

    public Mono<IpQuery> cualEsMiIp() {
        return WebClient.create("https://api.ipify.org")
                .get()
                .uri("/?format=json")
                .retrieve()
                .bodyToMono(String.class)
                .map(responseBody -> new JSONObject(responseBody))
                .flatMap(json -> {
                    IpQuery ipQuery = new IpQuery();
                    ipQuery.setIp(json.optString("ip"));
                    return ipQueryRepository.save(ipQuery);
                });
    }

    public Mono<IpQuery> ipDetalle() {
        return WebClient.create("https://api.ipify.org")
                .get()
                .uri("/?format=json")
                .retrieve()
                .bodyToMono(String.class)
                .flatMap(ipResponse -> {
                    String ip = new JSONObject(ipResponse).getString("ip");
                    return webClient.get()
                            .uri("/{ip}?token=0194073900d22b", ip)
                            .retrieve()
                            .bodyToMono(String.class);
                })
                .map(responseBody -> new JSONObject(responseBody))
                .flatMap(json -> {
                    IpQuery ipQuery = new IpQuery();
                    ipQuery.setIp(json.optString("ip"));
                    ipQuery.setCity(json.optString("city"));
                    ipQuery.setRegion(json.optString("region"));
                    ipQuery.setCountry(json.optString("country"));
                    ipQuery.setLoc(json.optString("loc"));
                    ipQuery.setOrg(json.optString("org"));
                    ipQuery.setPostal(json.optString("postal"));
                    ipQuery.setTimezone(json.optString("timezone"));
                    return ipQueryRepository.save(ipQuery);
                });
    }

    public Mono<IpQuery> consultaIpExterna(String ip) {
        return webClient.get()
                .uri("/{ip}?token=0194073900d22b", ip)
                .retrieve()
                .bodyToMono(String.class)
                .map(responseBody -> new JSONObject(responseBody))
                .flatMap(json -> {
                    IpQuery ipQuery = new IpQuery();
                    ipQuery.setIp(json.optString("ip"));
                    ipQuery.setCity(json.optString("city"));
                    ipQuery.setRegion(json.optString("region"));
                    ipQuery.setCountry(json.optString("country"));
                    ipQuery.setLoc(json.optString("loc"));
                    ipQuery.setOrg(json.optString("org"));
                    ipQuery.setPostal(json.optString("postal"));
                    ipQuery.setTimezone(json.optString("timezone"));
                    return ipQueryRepository.save(ipQuery);
                });
    }
}
