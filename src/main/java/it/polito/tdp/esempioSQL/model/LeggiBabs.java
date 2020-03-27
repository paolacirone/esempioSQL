package it.polito.tdp.esempioSQL.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LeggiBabs {

	public void run() {

		// 1. definire la stringa connessione, identifica i database a cui vogliamo
		// collegarci
		String jdbcURL = "jdbc:mysql://localhost/babs?user=root&password=root";

		// 2. identificare la stringa di connessine per aprirla
		try {
			Connection conn = DriverManager.getConnection(jdbcURL);

			// 3. eseguire un'interrogazione ES: conoscere i nomi delle stazioni
            // 4.Query
			String sql = "SELECT NAME FROM station WHERE landmark = ? " ;
			PreparedStatement st = conn.prepareStatement(sql);

			// si riferisce al ?
			st.setString(1, "Palo Alto");
			ResultSet res = st.executeQuery();
			// next restituisce un boolean e mi dice se la riga esiste o no

			while (res.next()) {

				String nomeStazione = res.getString("name");
				System.out.println(nomeStazione);

			}

			st.close();
			// prima di chiudere potrei creare anche un altro statement

			// 6.Chiudere la connessione
			conn.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		// FACTORY: creazione di un oggetto di una classe senza conoscerne il tipo
		// (senza new) uso un metodo fornito da un'altra classe che internamente farà da
		// new e conoscerà
		// il tipo di classe effettivo

	}

	public static void main(String[] args) {

		LeggiBabs babs = new LeggiBabs();
		babs.run();

	}

}
