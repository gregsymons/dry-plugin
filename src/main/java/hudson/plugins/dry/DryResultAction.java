package hudson.plugins.dry;

import java.util.Collection;
import java.util.Collections;

import jenkins.tasks.SimpleBuildStep;

import hudson.model.AbstractBuild;
import hudson.model.Action;
import hudson.model.Run;
import hudson.plugins.analysis.core.HealthDescriptor;
import hudson.plugins.analysis.core.PluginDescriptor;
import hudson.plugins.analysis.core.AbstractResultAction;

/**
 * Controls the live cycle of the DRY results. This action persists the
 * results of the DRY analysis of a build and displays the results on the
 * build page. The actual visualization of the results is defined in the
 * matching <code>summary.jelly</code> file.
 * <p>
 * Moreover, this class renders the DRY result trend.
 * </p>
 *
 * @author Ulli Hafner
 */
public class DryResultAction extends AbstractResultAction<DryResult> implements SimpleBuildStep.LastBuildAction {
    /**
     * Creates a new instance of <code>PmdResultAction</code>.
     *  @param owner
     *            the associated build of this action
     * @param healthDescriptor
     *            health descriptor to use
     * @param result
     */
    public DryResultAction(final Run<?, ?> owner, final HealthDescriptor healthDescriptor, final DryResult result) {
        super(owner, new DryHealthDescriptor(healthDescriptor), result);
    }

    @Override
    public String getDisplayName() {
        return Messages.DRY_ProjectAction_Name();
    }

    @Override
    protected PluginDescriptor getDescriptor() {
        return new DryDescriptor();
    }

    @Override
    public Collection<? extends Action> getProjectActions() {
        return Collections.singleton(new DryProjectAction(getOwner().getParent(), DryResultAction.class));
    }
}
