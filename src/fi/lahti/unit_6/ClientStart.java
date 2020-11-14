package fi.lahti.unit_6;

import fi.lahti.unit_6.webserver.Client;

public class ClientStart {

    public static void main(String[] args) {

      Client client = new Client();
      client.closeConnection();

    }
}
