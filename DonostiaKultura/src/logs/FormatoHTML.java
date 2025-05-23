package logs;

import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class FormatoHTML extends Formatter {
	@Override
	public String format(LogRecord record) {
		return String.format("<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>%n", record.getLevel(),
				formatMessage(record), new java.util.Date(record.getMillis()), Thread.currentThread().getName());
	}

	@Override
	public String getHead(Handler h) {
		return """
							<html>
							<head>
							<title>DonostiaLogs</title>
							<style>
							table { width: 100%; border-collapse: collapse; }
							th, td { border: 1px solid black; padding: 8px; text-align: left; }
							th { background-color: #f2f2f2; }
							</style>
							</head>
							<body>
							<table>
							<tr>
				<th>Nivel</th>
				<th>Mensaje</th>
				<th>Fecha</th>
				<th>Hilo</th>
				</tr>
							 """;
	}

	@Override
	public String getTail(Handler h) {
		return "</table></body></html>";
	}
}
