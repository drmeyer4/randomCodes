class CountBinaryOnes {
	public static Integer number(final Integer value) {
		final class CountRecursive {
			public Integer countRecursive(final Integer numberOfOnes, final Integer value) {
				if (value == 0) return numberOfOnes;
				// the >>> operator does a right shift without sign extension
				// that way, zero's are padded to the beginning, avoiding an infinite loop
				return countRecursive((numberOfOnes + (((value & 1) == 1) ? 1 : 0)), (value >>> 1));
			}
		}
		return new CountRecursive().countRecursive(0, value);
	}
}
