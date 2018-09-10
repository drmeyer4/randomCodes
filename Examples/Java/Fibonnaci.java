class Fibonnaci {
	public static List<BigInteger> sequence(final Integer end) {
		final class FibInternal {
			private List<BigInteger> sequenceR(final List<BigInteger> list, final Integer end) {
				if(end <= 0) return list;
				else
					list.add(list.get(list.size() - 2).add(list.get(list.size() - 1)));
					return sequenceR(list, (end - 1));
			}
		}
		return new FibInternal().sequenceR(new ArrayList<>(Arrays.asList(BigInteger.ZERO, BigInteger.ONE)), (end - 1));
	}
}
