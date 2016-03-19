import java.util.*;
import java.io.*;

/* Mighty Cohadar */
public class TopFox {

	public int possibleHandles(String familyName, String givenName) {
		Set<String> S = new HashSet<>();
		for (int i = 1; i <= familyName.length(); i++) {
			for (int j = 1; j <= givenName.length(); j++) {
				S.add(familyName.substring(0, i) + givenName.substring(0, j));
			}
		}
		return S.size();
	}

}

