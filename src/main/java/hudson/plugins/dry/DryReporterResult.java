package hudson.plugins.dry;

import hudson.model.AbstractBuild;
import hudson.model.Run;
import hudson.plugins.analysis.core.ParserResult;
import hudson.plugins.analysis.core.ResultAction;
import hudson.plugins.analysis.core.BuildResult;

/**
 * Represents the aggregated results of the DRY analysis in m2 jobs.
 *
 * @author Ulli Hafner
 */
public class DryReporterResult extends DryResult {
    private static final long serialVersionUID = -2812927497499345424L;

    /**
     * Creates a new instance of {@link DryReporterResult}.
     *  @param build
     *            the current build as owner of this action
     * @param defaultEncoding
     *            the default encoding to be used when reading and parsing files
     * @param result
 *            the parsed result with all annotations
     * @param usePreviousBuildAsReference
*            determines whether to use the previous build as the reference
*            build
     * @param useStableBuildAsReference
*            determines whether only stable builds should be used as
     */
    public DryReporterResult(final Run<?, ?> build, final String defaultEncoding, final ParserResult result,
            final boolean usePreviousBuildAsReference, final boolean useStableBuildAsReference) {
        super(build, defaultEncoding, result, usePreviousBuildAsReference, useStableBuildAsReference,
                DryMavenResultAction.class);
    }

    @Override
    protected Class<? extends ResultAction<? extends BuildResult>> getResultActionType() {
        return DryMavenResultAction.class;
    }
}

