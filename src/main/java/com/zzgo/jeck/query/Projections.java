package com.zzgo.jeck.query;

/**
 * 计算用类
 * @author guanwc
 *
 */
public class Projections {
	public static Projection Max(String col) {
		return new Projection(col, Criterion.Projection.MAX);
	}

	public static Projection Length(String col) {
		return new Projection(col, Criterion.Projection.LENGTH);
	}

	public static Projection Min(String col) {
		return new Projection(col, Criterion.Projection.MIN);
	}

	public static Projection Sum(String col) {
		return new Projection(col, Criterion.Projection.SUM);
	}
}
