package suporte;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Generator {

	public static String dataHoraParaArquivo() {

		Timestamp ts = new Timestamp(System.currentTimeMillis()); // passa os milissegundos atuais para o atributo ts

		return new SimpleDateFormat("yyyyMMddhhmmss").format(ts); // FORMATA A DATA
	}

}
