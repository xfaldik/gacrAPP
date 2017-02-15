/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.gacr.facade;

import cz.gacr.domain.Enterprise;
import cz.gacr.dto.EnterpriseDTO;
import cz.gacr.service.config.ServiceConfiguration;
import cz.gacr.services.BeanMappingService;
import cz.gacr.services.EnterpriseService;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import static org.hibernate.internal.util.collections.ArrayHelper.toList;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author olda
 */
@ContextConfiguration(classes = ServiceConfiguration.class)
public class EnterpriseFacadeTest extends AbstractTestNGSpringContextTests{
    
    @Mock
    EnterpriseService enterpriseServiceMock;
    
    
    @Mock
    private BeanMappingService beanMappingServiceMock;
    
    @InjectMocks
    EnterpriseFacade enterpriseFacade = new EnterpriseFacadeImpl();
    
    private Enterprise enterpriseBrock;
    private Enterprise enterpriseAhold;
    
    
    @BeforeMethod
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        enterpriseBrock = new Enterprise("Brock", "brock@kanto.jp", "mojeheslo");
        enterpriseAhold = new Enterprise("Ahold", "brock@kanto.jp", "mojeheslo");
    }
    
    @Test
    public void testFindAllTrainersFacade() throws Exception {
        EnterpriseDTO dto1 = new EnterpriseDTO();
        EnterpriseDTO dto2 = new EnterpriseDTO();

        doReturn(toList(new Enterprise[]{enterpriseBrock, enterpriseAhold})).when(enterpriseServiceMock).findAll();
        doReturn(toList(new EnterpriseDTO[]{dto1, dto2})).when(beanMappingServiceMock)
                .mapTo(Matchers.anyListOf(Enterprise.class), (Class<?>) Matchers.any(Class.class));

        Collection<EnterpriseDTO> trainerDTOs = enterpriseFacade.getAllEnterprises();
        Assert.assertEquals(trainerDTOs.size(), 2);

        verify(enterpriseServiceMock).findAll();
        verifyNoMoreInteractions(enterpriseServiceMock);
    }

    @Test
    public void testGetTrainerByIdFacade() throws Exception {
        EnterpriseDTO dto = new EnterpriseDTO();
        dto.setId(1);

        doReturn(enterpriseBrock).when(enterpriseServiceMock).findById(1);
        doReturn(dto).when(beanMappingServiceMock).mapTo(Matchers.any(Enterprise.class),
                (Class<?>) Matchers.any(Class.class));

        EnterpriseDTO trainerDTO = enterpriseFacade.getEnterpriseWithId(1);
        Assert.assertEquals(trainerDTO.getId(), 1);

        verify(enterpriseServiceMock).findById(1);
        verify(beanMappingServiceMock).mapTo(enterpriseBrock, EnterpriseDTO.class);
        verifyNoMoreInteractions(enterpriseServiceMock);
    }
    
}
