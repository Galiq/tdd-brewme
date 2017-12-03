package tddApp.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import tddApp.domain.Malt;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by galik on 15.10.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class MaltAdvancedManagerTest {

    MaltAdvancedManager maltAdvancedManager = new MaltAdvancedManager();

    @Mock
    private MaltManager maltManager;

    @Before
    public void setup() {
        maltAdvancedManager.setDataSource(maltManager);
    }

    @Test
    public void shouldReturnMaltCollection() {
        String idList = "1,2,3";
        when(maltManager.read(1)).thenReturn(new Malt(1, "pierwszy", 1, 1, "pierwszy"));
        when(maltManager.read(2)).thenReturn(new Malt(2, "drugi", 2, 2, "drugi"));
        when(maltManager.read(3)).thenReturn(new Malt(3, "trzeci", 3, 3, "trzeci"));

        ArrayList<Malt> arrayList;
        arrayList = maltAdvancedManager.getByIdList(idList);

        verify(maltManager).read(1);
        verify(maltManager).read(2);
        verify(maltManager).read(3);

        assertEquals("pierwszy", arrayList.get(0).getName());
        assertEquals("drugi", arrayList.get(1).getName());
        assertEquals("trzeci", arrayList.get(2).getName());
    }
}
