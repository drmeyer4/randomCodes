class Pronic {
	public static List<BigInteger> pronic(final Integer i, final Integer j) {
		if (i < 0 || j < 0) return new ArrayList<>(Arrays.asList(BigInteger.ZERO));
		class PronicR {
			private List<BigInteger> pronicR(final Integer start, final Integer end, final List<BigInteger> result) {
				if (end < start) return result;
				else
					result.add(0, BigInteger.valueOf((end * (end - 1))));
					return pronicR(start, (end - 1), result);
			}
		}
		return new PronicR().pronicR(i, j, new ArrayList<BigInteger>());
	}
}
