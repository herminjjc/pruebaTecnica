package com.precios.precios.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.precios.precios.entities.Precio;

public class PrecioRepositoryCustomImpl implements PrecioRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Precio findByFiltro(LocalDateTime fecha, Long idProdut, Long idCadena) {

		List<Predicate> predicates = new ArrayList<>();

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Precio> query = cb.createQuery(Precio.class);
		Root<Precio> root = query.from(Precio.class);

		predicates.add(cb.lessThanOrEqualTo(root.<LocalDateTime>get("starDate"), fecha));
		predicates.add(cb.greaterThanOrEqualTo(root.<LocalDateTime>get("endDate"), fecha));

		predicates.add(cb.equal(root.get("idProducto"), idProdut));
		predicates.add(cb.equal(root.get("brandId"), idCadena));

		query.orderBy(cb.desc(root.get("priority")));

		query.where(predicates.toArray(new Predicate[0]));

		List<Precio> lista = entityManager.createQuery(query).getResultList();

		if (lista.isEmpty())
			return null;
		else
			return lista.get(0);

	}

}
