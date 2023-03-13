package br.edu.ifpb.dac.igorsobral.projetojpa.read;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Read {

	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(isr);

	public String read() throws IOException {
		return br.readLine();
	}
}
