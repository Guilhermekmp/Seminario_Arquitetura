package load_balancer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Cliente {
    public static void main(String[] args) {

        int NUM_OF_REQUESTS = 15;
        Cliente client = new Cliente();

        ArrayList<String> ipServidores = new ArrayList <>();
        ipServidores.add("192.168.0.1");
        ipServidores.add("192.168.0.2");
        ipServidores.add("192.168.0.3");
        ipServidores.add("192.168.0.4");
        ipServidores.add("192.168.0.5");

        Map<String, Integer> pesoIpServidores = new HashMap<>();
        pesoIpServidores.put("192.168.0.1",  6);
        pesoIpServidores.put("192.168.0.2",  6);
        pesoIpServidores.put("192.168.0.3",  3);

        client.printNextTurn("Random");
        LoadBalancer random = new RandomLoadBalancer(ipServidores);
        client.simulateConcurrentClientRequest(random, NUM_OF_REQUESTS);

        client.printNextTurn("Round-Robin");
        LoadBalancer roundRobbin = new RoundRobinLoadBalancer(ipServidores);
        client.simulateConcurrentClientRequest(roundRobbin, NUM_OF_REQUESTS);

        client.printNextTurn("Weighted-Round-Robin");
        LoadBalancer weightedRoundRobin = new WeightedRoundRobinLoadBalancer(pesoIpServidores);
        client.simulateConcurrentClientRequest(weightedRoundRobin, NUM_OF_REQUESTS);

        System.out.println("Fim das requisições");

    }

    private void simulateConcurrentClientRequest(LoadBalancer loadBalancer, int numOfCalls) {

        IntStream
                .range(0, numOfCalls)
                .parallel()
                .forEach(i ->
                        System.out.println(
                                "IP: " + loadBalancer.getIp()
                                        + " --- Requisição do Cliente: " + i
                                        + " --- [Thread: " + Thread.currentThread().getName() + "]")
                );
    }

    private void printNextTurn(String name) {
        System.out.println("\n---");
        System.out.println("Clientes começaram a mandar requisições para " + name + " Load Balancer");
        System.out.println("---\n");
    }

}
