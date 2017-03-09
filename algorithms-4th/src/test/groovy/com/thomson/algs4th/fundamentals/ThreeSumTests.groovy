package com.thomson.algs4th.fundamentals

import edu.princeton.cs.algs4.In
import edu.princeton.cs.algs4.StdRandom
import edu.princeton.cs.algs4.Stopwatch
import org.junit.Test

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created: 09/03/2017.
 */
class ThreeSumTests {

    @Test
    void testCount() {
        def file = new In("src/test/resources/2Kints.txt")
        println ThreeSum.count(file.readAllInts())
    }

    @Test
    void testRandomInput() {
        def a = new int[1001]
        for (i in 0..1000) {
            a[i] = StdRandom.uniform(-1000000, 1000000)
        }
        Stopwatch timer = new Stopwatch()
        def count = ThreeSum.count(a)
        def time = timer.elapsedTime()
        println "$count triples $time"
    }
}
