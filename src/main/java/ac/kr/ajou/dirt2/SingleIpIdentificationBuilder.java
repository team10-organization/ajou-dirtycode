package ac.kr.ajou.dirt2;

import java.util.HashSet;
import java.util.Set;

public class SingleIpIdentificationBuilder implements IdentificationBuilder {
    @Override
    public Set<String> buildCombinedIdentification(PcBangEvent pbe) {
        // single IP
        Set<String> idetification = new HashSet<>();
        if (pbe.getIp() != null) {
            idetification.add(pbe.getIp());
        }
        return idetification;
    }
}
