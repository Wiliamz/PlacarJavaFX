//ADICIONAR ESSA CARALHA NUM PROJETO NOVO DEPOIS PARA ENTREGAR E MOSTRAR
//GRATO DESDE JÁ
package com.acme.commons;

import com.acme.model.JogoDto;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import com.acme.controller.ClientHandler;
import com.acme.enums.Acoes;
import com.acme.enums.TipoJogo;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel Cardoso
 */
public final class Server {

//    private static Server instancia = null;
    private static final List<ClientHandler> clients = new ArrayList<>();
    private static JogoDto jogo;

    public Server() {
        // server is listening on port 5056
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(5056);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

        jogo = new JogoDto();
        System.out.println("Rodando na porta 5056");

        while (true) {
            Socket socket = null;
            try {
                // Objeto socket para receber mensagens do cliente
                socket = serverSocket.accept();

                System.out.println("Novo cliente conectado : " + socket);

                // Novo objeto client com nova thread
                ClientHandler client = new ClientHandler(socket);
                clients.add(client);
                client.start();
            } catch (Exception e) {
                try {
                    socket.close();
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
                e.printStackTrace();
            }
        }
    }

    public static List<ClientHandler> getClients() {
        return clients;
    }

    public static JogoDto getJogo() {
        return jogo;
    }

//    public static void atualizarTempoDecorrido() {
//        Timer timer = new Timer();
//        TimerTask task = new TimerTask() {
//            public void run() {
//                if (Server.jogo.getTempoDecorrido() < Server.jogo.getTempoEstimado() && !Server.jogo.isPausado()) {
//                    Server.jogo.setTempoDecorrido(Server.jogo.getTempoDecorrido() + 1);
//                    System.out.println("TEMPO ------->" + Server.jogo.getTempoDecorrido());
//                } else {
//                    timer.cancel();
//                }
//            }
//        };
//        timer.schedule(task, 1000, 1000);
//    }
    public static void startGame(String tipoJogo, String tempoJogo, String timeA, String timeB) {
        Server.jogo.setJogando(true);
        Server.jogo.setTipoJogo(TipoJogo.valueOf(tipoJogo.toUpperCase()));
        Server.jogo.setTempoEstimado(Utils.tempoConverter(tempoJogo));
        Server.jogo.setTempoDecorrido(0);
        Server.jogo.setTimeA(timeA);
        Server.jogo.setTimeB(timeB);
//        Server.atualizarTempoDecorrido();
        for (ClientHandler c : Server.getClients()) {
            c.sendMessage(Acoes.INICIAR_JOGO.name() + ":" + tipoJogo + ";" + tempoJogo + ";" + timeA + ";" + timeB);
        }
    }

    public static void addPontosA() {
        Server.jogo.addPontosA();
        for (ClientHandler c : Server.getClients()) {
            c.sendMessage(Acoes.ADD_PONTOS_A.name() + ":" + 1);
        }
    }

    public static void addPontosA(int qtd) {
        Server.jogo.addPontosA(qtd);
        for (ClientHandler c : Server.getClients()) {
            c.sendMessage(Acoes.ADD_PONTOS_A.name() + ":" + qtd);
        }
    }

    public static void addPontosB() {
        Server.jogo.addPontosB();
        for (ClientHandler c : Server.getClients()) {
            c.sendMessage(Acoes.ADD_PONTOS_B.name() + ":" + 1);
        }
    }

    public static void addPontosB(int qtd) {
        Server.jogo.addPontosB(qtd);
        for (ClientHandler c : Server.getClients()) {
            c.sendMessage(Acoes.ADD_PONTOS_B.name() + ":" + qtd);
        }
    }

    public static void removePontosA() {
        Server.jogo.removePontosA();
        for (ClientHandler c : Server.getClients()) {
            c.sendMessage(Acoes.REMOVE_PONTOS_A.name() + ":" + Server.jogo.getPontosA());
        }
    }

    public static void removePontosB() {
        Server.jogo.removePontosB();
        for (ClientHandler c : Server.getClients()) {
            c.sendMessage(Acoes.REMOVE_PONTOS_B.name() + ":" + Server.jogo.getPontosB());
        }
    }

    public static void pauseGame() {
        Server.jogo.setPausado(true);
        for (ClientHandler c : Server.getClients()) {
            c.sendMessage(Acoes.PAUSE.name() + ":" + Server.jogo.isPausado());
        }
    }

    public static void continueGame() {
        Server.jogo.setPausado(false);
//        Server.atualizarTempoDecorrido();
        for (ClientHandler c : Server.getClients()) {
            c.sendMessage(Acoes.PLAY.name() + ":" + Server.jogo.isPausado());
        }
    }

    public static void addProrrogacao(int qtd) {
        Server.jogo.setTempoProrrogacacao(qtd);
        for (ClientHandler c : Server.getClients()) {
            c.sendMessage(Acoes.PRORROGACAO.name() + ":" + Server.jogo.getTempoProrrogacacao());
        }
    }

    public static void setImagem(String base) {
        Server.jogo.setBase64Image(base);
        for (ClientHandler c : Server.getClients()) {
            c.sendMessage(Acoes.IMAGEM.name() + ":" + base);
        }
    }

    public static void endGame() {
        Server.jogo.setTerminada(true);
        for (ClientHandler c : Server.getClients()) {
            c.sendMessage(Acoes.STOP.name() + ":" + true);
        }
    }
}
