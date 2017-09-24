#include <iostream>
#include <string>
#include <vector>
#include <set>
#include <limits.h>
using namespace std;

set<string> S;
set<string> UnusedCodes;

int num_attemps;

void fillS() {
	for (int a = 1; a <= 6; ++a) {
		for (int b = 1; b <= 6; ++b) {
			for (int c = 1; c <= 6; ++c) {
				for (int d = 1; d <= 6; ++d) {
					int num = d+c*10+b*100+a*1000;
					string s = to_string(num);
					S.insert(s);
					UnusedCodes.insert(s);
				}
			}
		}
	}
}

pair<int,int> calcularNB(string a, string b) {
	pair<int,int> res(0,0);
	for (int i = 0; i < 4; ++i) if (a[i] == b[i]) { a[i] = -2; b[i] = -1; ++res.first; }
	for (int i = 0; i < 4; ++i) {
		for (int j = 0; j < 4; ++j) {
			if (a[i] == b[j]) { a[i] = -2; b[j] = -1; ++res.second; }
		}
	}
	return res;
}

string minimax() { // R(g,s) = calcularNB(g,s), code if we'd played g being s the solution
	set<string>::iterator g, s;
	set<string> guesses;
	int max = -1;
	for (g = UnusedCodes.begin(); g != UnusedCodes.end(); ++g) {
		set<pair<int,int> > Z_g;
		vector<pair<int,int> > AllCodes(S.size()); int i = 0;
		for (s = S.begin(); s != S.end(); ++s) { // Construct Z(g) = { R(g,s):s € S}
			pair<int,int> val = calcularNB(*g,*s); 
			
			Z_g.insert(val);
			AllCodes[i] = val; ++i;
		}
		int min = INT_MAX;
		// G(g,z) = |{s € S : R(g,s} != z| !!!! H(g) = min{G(g,z) : z € Z(g)}
		for (set<pair<int,int> >::iterator it = Z_g.begin();it != Z_g.end(); ++it) {
			int G = 0;
			for (int i = 0; i < AllCodes.size(); ++i) {
				if (AllCodes[i] == *it) ++G;
			}
			if (min > AllCodes.size()-G) min = AllCodes.size()-G;
		}
		if (max == min) guesses.insert(*g);
		else if (max < min) { guesses.clear(); max = min; guesses.insert(*g); }
	}
	// Of all the maximized we return if possible a code of S
	for (set<string>::iterator it = guesses.begin(); it != guesses.end(); ++it) {
		if (S.find(*it) != S.end()) return *it;
	}
	return *(guesses.begin());
}

string nextGuess() {
	++num_attemps;
	if (num_attemps == 1) { string r = "1122"; S.erase(r); UnusedCodes.erase(r); return r; }
	
	string r = minimax();
	//~ string r = *(S.begin());
	S.erase(r);
	UnusedCodes.erase(r);
	return r;
}

void actuS(string lg, pair<int,int> lpair) {
	set<string>::iterator itS = S.begin();
	while (itS != S.end()) {
		pair<int,int> p = calcularNB(*itS,lg);
		
		if (lpair != p) itS = S.erase(itS);
		else ++itS;
	}
}

void tryAll();

int main() {
	/// Descomentar y comentar lo otro del main para comprobar todos los valores
	//~ tryAll();
	
	num_attemps = 0;
	cout << "Enter solution: ";
	string solution; cin >> solution; cout << endl;
	fillS();
	string guess = nextGuess();
	while (guess != solution) {
		cout << "Proposed code = " << guess << " step: " << num_attemps << endl;
		pair<int,int> NB = calcularNB(guess,solution); 
		cout << "black: " << NB.first << " " << " white: " << NB.second << endl;
		actuS(guess,NB);
		guess = nextGuess();
	}
	cout << "--------" <<endl << "Solution found = " << guess << " in " << num_attemps << " steps" << endl;
}


//
//
// Try all the possibilities and gives an averge
//
//

void tryAll() {
	float ataaaaa = 0;
	for (int a = 1; a <= 6; ++a) {
		for (int b = 1; b <= 6; ++b) {
			for (int c = 1; c <= 6; ++c) {
				for (int d = 1; d <= 6; ++d) {
					num_attemps = 0;
					int qwas = 1;
					string solution = to_string(d+c*10+b*100+a*1000);
					fillS();
					string guess = nextGuess();
					while (guess != solution) {
						++qwas;
						pair<int,int> NB = calcularNB(guess,solution); 
						actuS(guess,NB);
						guess = nextGuess();
					}
					cout << solution << " pasos: " << qwas << endl;
					ataaaaa += qwas;
				}
			}
		}
	}
	cout << ataaaaa/(6*6*6*6) << endl;
}
