import { useEffect, useState } from "react"
import type { Certification } from "../types/Certification"

function Certifications() {

  const [certifications, setCertifications] = useState<Certification[]>([])

  useEffect(() => {

    fetch("http://localhost:8080/api/certifications")
      .then((response) => response.json())
      .then((data: Certification[]) => {
        setCertifications(data)
      })

  }, [])

  return (
    <section id="certifications" className="px-6 py-24">

      <div className="mx-auto max-w-6xl">

        <p className="mb-3 text-sm uppercase tracking-[0.3em] text-gray-500">
          Certifications
        </p>

        <h2 className="text-4xl font-bold md:text-5xl">
          Certifications I've earned.
        </h2>

        <div className="mt-12 grid gap-6 md:grid-cols-2">

          {certifications.map((certification) => (

            <article
              key={certification.id}
              className="rounded-2xl border border-white/10 bg-white/[0.03] p-6"
            >

              <p className="text-sm text-gray-500">
                {certification.issuer}
              </p>

              <h3 className="mt-3 text-2xl font-bold">
                {certification.name}
              </h3>

              <p className="mt-4 text-gray-400">
                Issued: {certification.issueDate}
              </p>

              {certification.credentialUrl && (
  <a
    href={certification.credentialUrl}
    target="_blank"
    rel="noreferrer"
    className="mt-6 inline-block rounded-lg bg-white px-4 py-2 text-sm text-black hover:bg-gray-200"
  >
    View Credential
  </a>
  )}
  </article>
   
))}

        </div>

      </div>

    </section>
  )
}

export default Certifications