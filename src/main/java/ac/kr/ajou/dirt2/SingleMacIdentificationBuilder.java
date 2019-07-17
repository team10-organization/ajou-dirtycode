package ac.kr.ajou.dirt2;

import java.util.HashSet;
import java.util.Set;

public class SingleMacIdentificationBuilder implements IdentificationBuilder {
    @Override
    public Set<String> buildCombinedIdentification(PcBangEvent pbe) {
        Set<String> identificationValues = new HashSet<>();
        if (isValidMac(pbe.getMac())) {
            String[] macAddresses = pbe.getMac().split(",");
            if (macAddresses.length <= 100) {
                for (int i = 0; i < macAddresses.length; i++) {
                    identificationValues.add(macAddresses[i]);
                }
            } else {
                logErrorMessage("Mac address too many");
            }
        }
        logErrorMessage("Mac address is wrong");
        return identificationValues;
    }

    private void logErrorMessage(String s) {
        System.out.println(s);
    }

    private boolean isValidMac(String mac) {
        return mac != null && !mac.isEmpty();
    }
}
