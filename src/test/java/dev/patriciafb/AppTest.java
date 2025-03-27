package dev.patriciafb;

import org.junit.jupiter.api.Test;
import dev.patriciafb.view.View;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class AppTest {
    @Test
    void testApp() {
        View mockView = mock(View.class);
        App app = new App(mockView);
        verify(mockView).start();
    }
}
