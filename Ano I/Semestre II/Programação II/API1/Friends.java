class Friends {

	private String pessoa1, pessoa2, trabalhopessoa1, trabalhopessoa2;
	private int numFriends = 10;
	
	public Friends (Person p1, Person p2) {

		if (p1.name() != p2.name()) {

			this.pessoa1 = p1.name();
			this.pessoa2 = p2.name();

			this.trabalhopessoa1 = p1.profession();
			this.trabalhopessoa2 = p2.profession();

		}

	}

	public String pessoa1 () {

		return this.pessoa1;

	}

	public String pessoa2 () {

		return this.pessoa2;

	}

	public String trabalhopessoa1 () {

		return this.trabalhopessoa1;

	}
	
	public String trabalhopessoa2 () {

		return this.trabalhopessoa2;

	}
}