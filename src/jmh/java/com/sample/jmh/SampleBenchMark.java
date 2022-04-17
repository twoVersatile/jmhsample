package com.sample.jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Fork(value = 2, jvmArgs = {"-Xms2G", "-Xmx2G"})
public class SampleBenchMark {

    @Benchmark
    @Timeout(time = 5, timeUnit = TimeUnit.SECONDS)
    public void stringConcatBenchMark(Blackhole bh) {
        for (int i = 0; i < 100; i++) {
            String s = " " + i;
            bh.consume(s);
        }
    }
}
