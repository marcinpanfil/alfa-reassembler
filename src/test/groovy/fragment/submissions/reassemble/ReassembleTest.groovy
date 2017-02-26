package fragment.submissions.reassemble

import fragment.submissions.MarcinPanfil
import spock.lang.Specification

/**
 * Created by Marcin Panfil on 26.02.17.
 */
class ReassembleTest extends Specification {

    def overlapCounter = new MarcinPanfil.Reassemble()

    def 'should merge into one line'() {
        expect:
        overlapCounter.reassemble(line) == result
        where:
        line                                              || result
        "aAaA;aAbaAa"                                     || "aAbaAaA"
        "AaBb;bb"                                         || "AaBbb"
        "bCc;AabCc"                                       || "AabCc"
        "aA;AbB;aAA"                                      || "aAAbB"
        "aA;AbB;aaA"                                      || "aaAbB"
        "a;a;aA;bA;a"                                     || "baA"
        "O draconia;conian devil! Oh la;h lame sa;saint!" || "O draconian devil! Oh lame saint!"
        TestString.INPUT                                  || TestString.OUTPUT

    }

    def 'should find two best fragments and merge them into one line'() {
        expect:
        overlapCounter.findTwoBestFragmentsAndMergedThem(line) == result
        where:
        line                                              || result
        "O draconia;conian devil! Oh la;h lame sa;saint!" || "O draconian devil! Oh la;h lame sa;saint!"
        "O draconian devil! Oh la;h lame sa;saint!"       || "O draconian devil! Oh lame sa;saint!"
        "O draconian devil! Oh lame sa;saint!"            || "O draconian devil! Oh lame saint!"
        TestString.INPUT                                  || TestString.FIRST_STEP
        TestString.FIRST_STEP                             || TestString.SECOND_STEP
        TestString.SECOND_STEP                            || TestString.THIRD_STEP
        TestString.THIRD_STEP                             || TestString.FOURTH_STEP
    }

    def 'test merge'() {
        expect:
        overlapCounter.merge(toMerge1, toMerge2) == merged
        where:
        toMerge1                       | toMerge2                                  || merged
        "O draconia"                   | "conian devil!"                           || "O draconian devil!"
        "Oh la"                        | "h lame sa"                               || "Oh lame sa"
        "Oh lame sa"                   | "saint!"                                  || "Oh lame saint!"
        "Neque porro quisquam est, qu" | "Neque porro quisquam est, qui dolorem i" || "Neque porro quisquam est, qui dolorem i"
    }

    def 'should return overlap size'() {
        expect:
        overlapCounter.getOverlapFragment(toOverlap1, toOverlap2) == overlapFragment
        where:
        toOverlap1                     | toOverlap2                                || overlapFragment
        "ABCDEF"                       | "DEFG"                                    || "DEF"
        "ABCDEF"                       | "XYZABC"                                  || "ABC"
        "ABCDEF"                       | "BCDE"                                    || "BCDE"
        "ABCDEF"                       | "XCDEZ"                                   || ""
        "Neque porro quisquam est, qu" | "Neque porro quisquam est, qui dolorem i" || "Neque porro quisquam est, qu"
    }
}
