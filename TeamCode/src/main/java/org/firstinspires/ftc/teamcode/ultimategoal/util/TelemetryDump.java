package org.firstinspires.ftc.teamcode.ultimategoal.util;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.ArrayList;

public class TelemetryDump {
    Telemetry telemetry;
    private ArrayList<TelemetryProvider> providers;

    public TelemetryDump(Telemetry telemetry) {
        this.telemetry = telemetry;
        this.providers = new ArrayList<>();
    }

    public void registerProvider(TelemetryProvider provider) {
        providers.add(provider);
    }

    public void removeProvider(TelemetryProvider provider) {
        providers.remove(provider);
    }

    public void update() {
        StringBuilder out = new StringBuilder();
        for (TelemetryProvider provider : providers) {
            out.append("---").append(provider.getName()).append("---\n");

            for (String entry : provider.getTelemetryData()) {
                out.append(entry).append("\n");
            }

            out.append("\n");
        }
        telemetry.addLine(out.toString());
        telemetry.update();
    }
}
